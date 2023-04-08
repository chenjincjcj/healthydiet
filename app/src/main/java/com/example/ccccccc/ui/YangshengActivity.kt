package com.example.ccccccc.ui

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ccccccc.Adaper.YangshengAdapter
import com.example.ccccccc.PengrenAdapter
import com.example.ccccccc.R
import com.example.ccccccc.xiaxian.Pengren
import com.example.ccccccc.xiaxian.Yangsheng
import kotlinx.android.synthetic.main.activity_yangsheng.*

class YangshengActivity : AppCompatActivity() {
    var yangshengList = ArrayList<Yangsheng>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yangsheng)
        initPengren()
        val layoutManager = GridLayoutManager(this, 1)
        recyclerView_yangsheng.layoutManager = layoutManager
        val adapter = YangshengAdapter(this, yangshengList)
        recyclerView_yangsheng.adapter = adapter
    }

    private fun initPengren() {
        val uri1 = Uri.parse("android.resource://$packageName/${R.raw.dongtian}")
        yangshengList.add(Yangsheng("冬天的第一食物",uri1.toString(),"冬 季 养 生\n" +
                "\n" +
                "民间有句话叫\n" +
                "\n" +
                "“冬季进补，来年打虎”\n" +
                "\n" +
                "冬季食补以温热补益为主\n" +
                "\n" +
                "强壮身体的同时，\n" +
                "\n" +
                "起到御寒的作用\n" +
                "\n" +
                "这些“冬季排名第一”的食疗方\n" +
                "\n" +
                "助你温暖过冬！\n" +
                "\n" +
                "01\n" +
                "\n" +
                "第一菜：白萝卜\n" +
                "\n" +
                "推荐理由：\n" +
                "\n" +
                "民间流传“冬吃萝卜夏吃姜”之谚语，也称萝卜为“土人参”。白萝卜的热量更低一些，维生素C含量更高一些，并且膳食纤维含量大。\n" +
                "\n" +
                "中医认为，冬季吃白萝卜，可健脾养胃、益气补精，且能预防疾病，对身体是很有好处的。冬季人们很注重养生饮食，却缺乏运动，体内会积聚过多的热，而白萝卜有助于消化、去咳止痰。\n" +
                "\n" +
                "推荐吃法：生吃促消化，其辛辣的成分可促胃液分泌，调整肠胃功能，还有一定的消炎作用。生吃白萝卜或者凉拌白萝卜可以最大限度地保留营养素。\n" +
                "\n" +
                "熟吃补气顺气，尤其和猪肉、羊肉等一起炖着吃，效果更佳。\n" +
                "\n" +
                "中老年人冬季食用时，可以使用炒制或者炖汤的烹制方法，白萝卜跟其他食物互补和搭配的效果都比较好。\n" +
                "\n" +
                "02\n" +
                "\n" +
                "第一杂粮：红薯\n" +
                "\n" +
                "推荐理由：\n" +
                "\n" +
                "冬天吃个热热的红薯，是最惬意的事情。红薯富含碳水化合物、膳食纤维、胡萝卜素、维生素以及钾、镁、铜、硒、钙等10多种微量元素。\n" +
                "\n" +
                "最佳吃法：虽然人们习惯吃烤红薯，但实际上，蒸红薯才是更健康的选择，不仅能减少营养的流失，还能减少因烤制而产生的有害物质。\n" +
                "\n" +
                "推荐吃法：红薯粥\n" +
                "\n" +
                "红薯含有大米、面粉缺乏的赖氨酸，可促进人体上皮细胞的成熟，提高人体抵抗力；冬季吃红薯还有防燥的功效，但不能多吃。中老年人脾胃虚弱，可多喝点红薯粥，因为它易于消化，保护胃肠，还能促进胃肠运动，使排便更加轻松，还能摆脱便秘的困扰。\n" +
                "\n" +
                "\n" +
                "03\n" +
                "\n" +
                "第一果：山楂\n" +
                "\n" +
                "推荐理由：\n" +
                "\n" +
                "山楂是秋冬的应季食材，作为一个药果同源的保健食品，山楂果营养丰富，酸甜可口，助消化解油腻。有健胃消食、活血化淤、改善循环、保护血管、降脂、扩张心脏冠脉、降血压的功效。\n" +
                "\n" +
                "老年人常吃能增强食欲、改善睡眠、预防心脑血管疾病，故被人们视为“长寿食品”。\n" +
                "\n" +
                "注意：山楂虽然美味，但不适合所有人吃。\n" +
                "\n" +
                "由于山楂中有机酸含量也非常高，会促进胃液的分泌。对于本身高酸的病人，比如消化性溃疡、反流性食管炎，胃酸分泌过多时就会加重症状。\n" +
                "\n" +
                "胃病、孕妇、牙病患者都不能生食山楂。山楂富含鞣酸和果胶，在胃酸的作用下与蛋白质结合生成一些不溶于水的沉淀物（鞣酸蛋白），鞣酸蛋白与果胶和食物残渣等交合在一起形成团状结块，将会增加植物性胃结石的风险。\n" +
                "\n" +
                "其他人群也不能过量生食山楂，每天生食山楂的总量应控制在3～5粒。\n" +
                "\n" +
                "04\n" +
                "\n" +
                "第一饮：红糖水\n" +
                "\n" +
                "推荐理由：\n" +
                "\n" +
                "冬天强调温补，就饮品来说，红糖水是最为适宜。红糖有“东方巧克力”的美誉，其好处在于其具有暖胃健脾、缓解疼痛的功效，而且富含钙、铁等人体必需的矿物质。\n" +
                "\n" +
                "推荐吃法：红糖水一定要煮一下，煮过的红糖水比直接用热水冲泡的更易吸收。\n" +
                "\n" +
                "最佳搭配：煮红糖水的时候，可以加一小块姜，将姜拍碎加入即可，和红糖一起煮大约10分钟，最后把姜捞出，这样温补的效果更好。也可加入银耳、枸杞、红枣或是红豆一起煮，有利水利尿的功效。\n" +
                "\n" +
                "\n" +
                "05\n" +
                "\n" +
                "第一肉：羊肉\n" +
                "\n" +
                "推荐理由：\n" +
                "\n" +
                "羊肉性温热可温胃御寒，是冬季具有进补和防寒双重效果的最佳美味。羊肉有助元阳、补精血、疗肺虚之功效，对气喘、气管炎、肺病及虚寒的病人相当有益。\n" +
                "\n" +
                "推荐吃法：白菜萝卜羊肉汤——大补驱寒\n" +
                "\n" +
                "把羊肉切成片，加入少量姜、葱段，开大火煮沸，除去泡沫，然后再小火慢炖。炖到七八成熟的时候，加入切碎的大白菜和白萝卜片，煮到熟就行了。起锅时可以再撒些香菜、蒜末和盐就可以吃了。\n" +
                "\n" +
                "\n" +
                "06\n" +
                "\n" +
                "第一零食：栗子\n" +
                "\n" +
                "推荐理由：\n" +
                "\n" +
                "栗子有“干果之王”的美誉，是“味美价廉”的滋补良药。它的碳水化合物比其他坚果多3～4倍，蛋白质和脂肪相对较少，还富含胡萝卜素、核黄素、维生素C等多种维生素。栗子味甘、性温，有补肾壮腰、健脾和胃、活血止血的功效，有助改善肾虚，腰膝酸软无力、筋骨疼痛等病症。\n" +
                "\n" +
                "推荐吃法：用栗子、大枣、茯苓、大米煮粥喝；无论是熬汤还是炒食，应细细咀嚼，可以达到更好的补益效果。\n" +
                "\n" +
                "最佳搭配：\n" +
                "\n" +
                "○栗子炖鸡：适合手脚冰凉、怕冷的人。\n" +
                "\n" +
                "○栗子粥：进入冬季以后，饮食中的肉类增多，经常喝栗子粥调理，不仅补肾，而且滋养脾胃，缓解肉食带来的负担。"))
        val uri2 = Uri.parse("android.resource://$packageName/${R.raw.dongtian}")
   yangshengList.add(Yangsheng("越吃越瘦的炒菜",uri2.toString(),"越吃越瘦的炒菜：\n" +
           "西红柿炒鸡蛋\n" +
           "芹菜炒牛肉\n" +
           "西兰花炒鸡胸肉\n" +
           "西葫芦炒虾仁\n" +
           "芦笋炒海鲜菇\n" +
           "山药炒木耳越吃越瘦的炒菜：\n" +
           "西红柿炒鸡蛋\n" +
           "芹菜炒牛肉\n" +
           "西兰花炒鸡胸肉\n" +
           "西葫芦炒虾仁\n" +
           "芦笋炒海鲜菇\n" +
           "山药炒木耳"))

    }
}