package woo.sopt22.kotlinexam.Scrollview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main7.*
import woo.sopt22.kotlinexam.R

class Main7Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        var content = """
            [ABOUT MOVIE]

 상.상.초.월 神세계!
 본 적 없고, 볼 수도 없는 저승 세계가 눈 앞에 펼쳐진다!

 누구나 가지만, 아무도 본 적 없는 세계가 오는 12월 스크린에 펼쳐진다. 동명의 웹툰을 스크린에 옮긴 영화 <신과함께>는 인간은 죽음 후 저승에서 각기 다른 지옥을 경험한다는 한국적 사후 세계관을 기반으로 하고 있다. 영화는 한국적 세계관을 바탕으로 사후 49일 동안 7번의 지옥 재판을 무사히 거쳐야만 환생할 수 있다는 전제로 이야기를 확장시켰다. 인간은 저승에서 끝이 아니라 새로운 삶을 시작하게 되는 것이다. 화재 현장에서 죽음을 맞이한 소방관 ‘자홍’은 저승에서 치뤄야 하는 7번의 재판 동안 그를 변호하고 호위하는 삼차사 ‘강림’, ‘해원맥’, ‘덕춘’을 만나 이 모든 과정을 겪게 된다. 살인, 나태, 거짓, 불의, 배신, 폭력, 천륜 7개의 지옥 재판을 통해 사는 동안 그가 지은 크고 작은 죄들을 알아가는 ‘자홍’의 여정을 따라가다 보면 그를 응원하는 것은 물론 관객 모두가 자신의 삶을 되짚어 보는 진기한 경험을 하게 된다. 모든 인간이 겪는 죽음과 삶, 그 경계에서 인간의 삶을 관통하는 희로애락을 다시금 떠올리고, 자홍의 이야기에 우리 자신을 투영하게 되는 것이다. ‘자홍’이 주는 공감과 더불어 삼차사의 활약은 영화에 또 다른 활력을 불어 넣는다. 저승 삼차사들은 49명의 망자를 환생시켜야만 환생을 보장받을 수 있기에 ‘자홍’의 재판에 모든 노력을 쏟아 붓는다. 하지만 숱한 세월 망자를 변호하고 호위했던 그들조차 매 재판에서 만나는 고난과 숙제는 어렵고 그로 인해 시행착오를 겪는다. 또한 자홍의 재판을 어지럽히는 원귀가 출현하면서 차사들은 저승과 이승을 동시에 오가고, 그들이 선보이는 새로운 이야기에 한 시도 눈을 뗄 수 없게 만든다.

 한국 고유의 전통 설화에 신선한 상상력을 덧입히고, 매력적인 캐릭터들이 가세한 영화 <신과함께-죄와 벌>. 이승과 저승, 삶과 죽음의 경계를 넘나드는 장대한 이야기를 통해 새로운 차원의 재미와 감동을 선사할 것이다.


 [ABOUT MOVIE]

 웹툰계의 神 스크린으로 환생!
        """.trimIndent()

        // """ String~~   """ 쌍따옴표 3개 사이에 텍스트 형식을 넣게 되면 형식을 유지한 채로 텍스트 문장들을 가져와서 사용할 수 있다.
        // trimIndent()는 앞에 존재하는 여백을 없애줌!
        moview_content.text = content
    }
}
