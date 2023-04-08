package com.example.ccccccc.ui.kepu

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ccccccc.R
import com.example.ccccccc.xiaxian.Pengren
import kotlinx.android.synthetic.main.activity_kepu.*

class KepuActivity : AppCompatActivity() {
    var kepuList = ArrayList<Kepu>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kepu)
        initKepu()
        val layoutManager = GridLayoutManager(this, 1)
        recyclerView_kepu.layoutManager = layoutManager
        val adapter = KepuAdapter(this, kepuList)
        recyclerView_kepu.adapter = adapter

    }

    private fun initKepu() {
        val uri1 = Uri.parse("android.resource://$packageName/${R.raw.songhuuadan}")
        kepuList.add(Kepu("松花蛋的知识",uri1.toString(),"松花蛋，又称皮蛋、变蛋、灰包蛋、包蛋等，是一种中国传统风味蛋制品。主要原材料是鸭蛋，口感鲜滑爽口，微咸，色香味均有独到之处。松花蛋不仅为国内广大消费者所喜爱，在国际市场上也享有盛名。\n" +
                "\n" +
                "经过特殊的加工方式后，松花蛋会变得黝黑光亮，上面还有白色的花纹，闻一闻则有一种特殊的香气扑鼻而来，是人民群众喜欢的美食之一。\n" +
                "\n" +
                "松花蛋，不但是美味佳肴，而且还有一定的药用价值。王士雄《随息居饮食谱》中说：“皮蛋，味辛、涩、甘、咸，能泻热、醒酒、去大肠火，治泻痢，能散能敛。”中医认为皮蛋性凉，可治眼疼、牙疼、高血压、耳鸣眩晕等疾病。\n" +
                "\n" +
                "松花蛋的传统制法，几乎都用到中药密陀僧，但皮蛋中的铅含量使人望而生畏。人们已研制出了无铅皮蛋的吃法，爱吃皮蛋的人们，不必为铅中毒而担心了。"))
        val uri2 = Uri.parse("android.resource://$packageName/${R.raw.doudou}")
    kepuList.add(Kepu("突然出现的小痘痘",uri2.toString(),"脸上起白色的小痘痘\n" +
            "脸上起白色的小痘痘原因较多，比如不良饮食、雄激素刺激、毛囊炎等原因引起，建议患者根据不同类型的小痘痘，采用针对性治疗方法。\n" +
            "1、不良饮食：很多患者经常喜欢吃辛辣刺激性食物，或者油炸类食物，比较容易出现小痘痘。另外，经常熬夜或者经常加班工作的人，也有可能引起内分泌失调，导致脸上出现小痘痘，建议患者平时注意健康饮食习惯，不要熬夜，改善内分泌情况，小痘痘可以慢慢缓解。\n" +
            "2、雄激素刺激：青春期后人体内雄激素水平升高，激素会刺激皮脂腺发育，对于皮脂腺分泌旺盛的人群，有可能引起皮脂腺导管角化异常，从而出现导管堵塞，局部容易形成角质栓，所以会有白色的小痘痘，建议患者通过涂抹药膏改善症状，比如阿达帕林凝胶、水杨酸软膏等。\n" +
            "3、毛囊炎：在毛囊中痤疮丙酸杆菌大量繁殖，其中酯酶会分解为皮质变成游离脂肪酸，会加重皮肤炎症，建议患者通过抗炎的方式治疗，比如局部涂抹含有芦荟胶成分的药膏。"))
    }
}