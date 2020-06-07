# Mercy_Android 🦋
### BY 김채원 박세란 양혜선 👼🏾👼👼🏻

# 1. 프로젝트 사용 라이브러리

![image](https://user-images.githubusercontent.com/59532818/83954194-061cff80-a882-11ea-9078-46c518c651ae.png)


# 2. 프로그램 구조

<img width="193" alt="스크린샷 2020-06-07 오전 8 00 08" src="https://user-images.githubusercontent.com/37995236/83956070-f65ae680-a894-11ea-8f05-f719d2bbdc96.png">

# 3. 핵심 기능 구현 방법 정리

## 3-1. guideLine
약에 대한 설명을 구조적으로 정리

## 3-2. fragment
하나의 액티비티에서 여러 상황을 연출

<img width="358" alt="스크린샷 2020-06-07 오전 10 39 26" src="https://user-images.githubusercontent.com/37995236/83958323-34630500-a8ab-11ea-9078-79ce19b34efd.png">
<img width="359" alt="스크린샷 2020-06-07 오전 10 39 15" src="https://user-images.githubusercontent.com/37995236/83958325-375df580-a8ab-11ea-8fa4-a2f8379111d8.png">

1️⃣ xml 작성 -> 반복될 뷰
```
<FrameLayout
        android:id="@+id/fl_head_middle"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:paddingHorizontal="32dp"
        app:layout_constraintBottom_toTopOf="@+id/cl_head_bottom"
        app:layout_constraintTop_toBottomOf="@+id/cl_head_top"
        app:layout_constraintVertical_weight="3"/>
```
2️⃣반복될 뷰를 관리 -> activity.kt 작성
```
when(select){
    "head" -> {
        fragment = HeadFragment()
    }
    "digestive" -> {
        fragment = DigestiveFragment()
    }
    "respiratory" -> {
        fragment = RespiratoryFragment()
    }
    "etc" -> {
        fragment = EtcFragment()
    }
}

val fm: FragmentManager = supportFragmentManager
val fragmentTransaction: FragmentTransaction = fm.beginTransaction()
fragmentTransaction.replace(R.id.fl_head_middle, fragment)
fragmentTransaction.commit()
```


## 3-3. View Pager & Dot Indicator
사용자의 가로 스크롤 동작 따른 서비스 동작 분기 및 직관적인 스크롤 연출

정리 내용 -> [개인 정리 참고](https://github.com/Yanghyesun/AndroidArticle)

<img width="360" alt="스크린샷 2020-06-07 오전 10 37 56" src="https://user-images.githubusercontent.com/37995236/83958303-0c73a180-a8ab-11ea-9576-130a082ddb3e.png">


➡️ __View Pager & Tablayout__ 을 이용해서 구현❗️

1️⃣ dot indicator 디자인 만들어주기!(동그란 이미지) -> drawable폴더에 selector_dot_indicator.xml 생성

```
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:state_selected="false">
        <shape
            android:innerRadius="0dp"
            android:shape="ring"
            android:thickness="6dp"
            android:useLevel="false">
            <solid android:color="@color/colorGrey"/>
        </shape>
    </item>
    <item android:state_selected="true">
        <shape
            android:innerRadius="0dp"
            android:shape="ring"
            android:thickness="6dp"
            android:useLevel="false">
            <solid android:color="@color/colorOver4"/>
        </shape>
    </item>
</selector>
```

2️⃣view pager & tablayout 화면 만들어주기! -> activity_main.xml 파일 작성

```
<androidx.viewpager.widget.ViewPager
    android:id="@+id/vp_home"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />

<com.google.android.material.tabs.TabLayout
    android:id="@+id/tl_home"
    android:layout_width="match_parent"
    android:layout_height="20dp"
    app:layout_constraintBottom_toBottomOf="@+id/vp_home"
    app:tabBackground="@drawable/selector_dot_indicator"
    app:tabGravity="center"
    app:tabIndicatorHeight="0dp" />
```

3️⃣view pager 안에 화면을 fragment로 구현 -> fragment_view.xml 파일 작성<br/>
저는 위의 화면과 똑같이 만들었습니다 :) 나중에 쓸때는 디자인마다 다르겠죠?

```
<androidx.constraintlayout.widget.ConstraintLayout
     android:layout_width="match_parent"
     android:layout_height="match_parent">
     <ImageView
         android:id="@+id/img_ad"
         android:layout_width="match_parent"
         android:layout_height="match_parent"/>

     <TextView
         android:id="@+id/txt_ad"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         app:layout_constraintBottom_toBottomOf="parent"
         app:layout_constraintEnd_toEndOf="parent"
         app:layout_constraintStart_toStartOf="parent"
         app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

<br/>
자, xml 파일은 다 만들었는데 기능을 입혀봅시다〰️
<br/>

4️⃣ViewpagerAdapter 파일 만들기! -> ViewpagerAdapter.kt 파일 작성

```
class ViewpagerAdapter(fm: FragmentManager, private val page_count: Int) : FragmentStatePagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        val viewFragment = ViewFragment()
        val bundle = Bundle(page_count)
        bundle.putInt("id",position)
        viewFragment.arguments = bundle
        return viewFragment
    }

    override fun getCount(): Int = page_count
}
```

5️⃣각 화면다다 Fragment 처리 -> ViewFragment.kt 파일 작성( fragment_view.xml 파일과 연동)

```
class ViewFragment : Fragment() {
    var view_id = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        view_id = arguments!!.getInt("id")
        init()
    }

    private fun init(){
        when(view_id){
            0 -> {
                img_ad.setBackgroundColor(Color.GRAY)
                txt_ad.text="광고1"
            }
            1 -> {
                img_ad.setBackgroundColor(Color.BLUE)
                txt_ad.text="광고2"
            }
            2 -> {
                img_ad.setBackgroundColor(Color.CYAN)
                txt_ad.text="광고3"
            }
            3 -> {
                img_ad.setBackgroundColor(Color.MAGENTA)
                txt_ad.text="광고4"
            }
        }

    }
}
```

6️⃣Activity 에서 adapter 연결해주기 -> MainActivity.kt 파일 작성
```
vp_home.adapter = ViewPagerAdapter(fragmentManager,4)
vp_home.offscreenPageLimit = 3
tl_home.setupWithViewPager(vp_home)
```


## 3-4. scrollView
하나의 액티비티에 화면보다 많은 기능을 제공

## 3-5. animation
애니메이션을 효과를 넣어서 아래->위로 샤라락 되는 효과 적용

![Jun-07-2020 10-34-44](https://user-images.githubusercontent.com/37995236/83958245-9838fe00-a8aa-11ea-82cf-8f218c828aa4.gif)

```
val fade = ObjectAnimator.ofFloat(cb_btn_respiratory_first,View.TRANSLATION_Y,400f,0f)
val fade2 = ObjectAnimator.ofFloat(cb_btn_respiratory_second,View.TRANSLATION_Y,500f,0f)
val fade3 = ObjectAnimator.ofFloat(cb_btn_respiratory_third,View.TRANSLATION_Y,600f,0f)
val fade4 = ObjectAnimator.ofFloat(cb_btn_respiratory_fourth,View.TRANSLATION_Y,700f,0f)
val fade5 = ObjectAnimator.ofFloat(cb_btn_respiratory_fifth,View.TRANSLATION_Y,800f,0f)
AnimatorSet().run {
    playTogether(fade,fade2,fade3,fade4,fade5)
    duration = 2000
    start()
}
```



## 3-6. retrofit 통신

```
object RequestToServer{
    var retrofit = Retrofit.Builder()
        .baseUrl("") //건물의 주소.
        .addConverterFactory(GsonConverterFactory.create()) //retrofit으로 받아온 json데이터를 데이터 클래스로 변환하기 쉽게 해줌
        .build()

    var service: RequestInterface = retrofit.create(RequestInterface::class.java) //retrofit.create호출해 interface클래스 타입을 넘겨 실제 구현체를 만들어준다.
}
```

## 3-7. kotlin 확장 함수 사용
기본 json 구조를 확장 함수로 틀을 만들어줌!

```
fun<ResponseType> Call<ResponseType>.customEnqueue( //매개변수로 넘겨줄 함수들
    onFail : () -> Unit = { Log.d("network","통신에 실패했습니다.")},
    onSuccess : (ResponseType) -> Unit,
    onError : () -> Unit
) {
    this.enqueue(object : Callback<ResponseType>{
        override fun onFailure(call: Call<ResponseType>, t: Throwable) {
            onFail()
        }

        override fun onResponse(call: Call<ResponseType>, response: Response<ResponseType>) {
            response.body()?.let{//body가 있다면(not null) statuscode가 200-300사이
                onSuccess(it) // 통신 결과를 전달해 줍니다
            } ?: onError // body()가 null값 -> statusCode가 200-300이 아닌경우.아예 오류
        }
    })
}
```
