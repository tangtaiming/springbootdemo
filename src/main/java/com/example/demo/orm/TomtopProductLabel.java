package com.example.demo.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 数据
 * json : [{"id":1,"labelName":"new","labelType":1,"websiteId":1},{"id":2,"labelName":"hot","labelType":1,"websiteId":1},{"id":3,"labelName":"clearstocks","labelType":2,"websiteId":1},{"id":4,"labelName":"featured","labelType":1,"websiteId":1},{"id":5,"labelName":"freeShipping","labelType":2,"websiteId":1},{"id":6,"labelName":"special","labelType":1,"websiteId":1},{"id":7,"labelName":"OffPrice","labelType":1,"websiteId":1},{"id":8,"labelName":"Presale","labelType":1,"websiteId":1},{"id":10,"labelName":"new","labelType":1,"websiteId":2},{"id":11,"labelName":"hot","labelType":1,"websiteId":2},{"id":12,"labelName":"clearstocks","labelType":2,"websiteId":2},{"id":13,"labelName":"featured","labelType":1,"websiteId":2},{"id":14,"labelName":"freeShipping","labelType":2,"websiteId":2},{"id":15,"labelName":"special","labelType":1,"websiteId":2},{"id":16,"labelName":"OffPrice","labelType":1,"websiteId":2},{"id":17,"labelName":"Presale","labelType":1,"websiteId":2},{"id":18,"labelName":"new","labelType":1,"websiteId":3},{"id":19,"labelName":"hot","labelType":1,"websiteId":3},{"id":20,"labelName":"clearstocks","labelType":2,"websiteId":3},{"id":21,"labelName":"featured","labelType":1,"websiteId":3},{"id":22,"labelName":"freeShipping","labelType":2,"websiteId":3},{"id":23,"labelName":"special","labelType":1,"websiteId":3},{"id":24,"labelName":"OffPrice","labelType":1,"websiteId":3},{"id":25,"labelName":"Presale","labelType":1,"websiteId":3},{"id":26,"labelName":"new","labelType":1,"websiteId":4},{"id":27,"labelName":"hot","labelType":1,"websiteId":4},{"id":28,"labelName":"clearstocks","labelType":2,"websiteId":4},{"id":29,"labelName":"featured","labelType":1,"websiteId":4},{"id":30,"labelName":"freeShipping","labelType":2,"websiteId":4},{"id":31,"labelName":"special","labelType":1,"websiteId":4},{"id":32,"labelName":"OffPrice","labelType":1,"websiteId":4},{"id":33,"labelName":"Presale","labelType":1,"websiteId":4},{"id":34,"labelName":"new","labelType":1,"websiteId":5},{"id":35,"labelName":"hot","labelType":1,"websiteId":5},{"id":36,"labelName":"clearstocks","labelType":2,"websiteId":5},{"id":37,"labelName":"featured","labelType":1,"websiteId":5},{"id":38,"labelName":"freeShipping","labelType":2,"websiteId":5},{"id":39,"labelName":"special","labelType":1,"websiteId":5},{"id":40,"labelName":"OffPrice","labelType":1,"websiteId":5},{"id":41,"labelName":"Presale","labelType":1,"websiteId":5},{"id":42,"labelName":"new","labelType":1,"websiteId":6},{"id":43,"labelName":"hot","labelType":1,"websiteId":6},{"id":44,"labelName":"clearstocks","labelType":2,"websiteId":6},{"id":45,"labelName":"featured","labelType":1,"websiteId":6},{"id":46,"labelName":"freeShipping","labelType":2,"websiteId":6},{"id":47,"labelName":"special","labelType":1,"websiteId":6},{"id":48,"labelName":"OffPrice","labelType":1,"websiteId":6},{"id":49,"labelName":"Presale","labelType":1,"websiteId":6},{"id":50,"labelName":"new","labelType":1,"websiteId":7},{"id":51,"labelName":"hot","labelType":1,"websiteId":7},{"id":52,"labelName":"clearstocks","labelType":2,"websiteId":7},{"id":53,"labelName":"featured","labelType":1,"websiteId":7},{"id":54,"labelName":"freeShipping","labelType":2,"websiteId":7},{"id":55,"labelName":"special","labelType":1,"websiteId":7},{"id":56,"labelName":"OffPrice","labelType":1,"websiteId":7},{"id":57,"labelName":"Presale","labelType":1,"websiteId":7},{"id":58,"labelName":"new","labelType":1,"websiteId":8},{"id":59,"labelName":"hot","labelType":1,"websiteId":8},{"id":60,"labelName":"clearstocks","labelType":2,"websiteId":8},{"id":61,"labelName":"featured","labelType":1,"websiteId":8},{"id":62,"labelName":"freeShipping","labelType":2,"websiteId":8},{"id":63,"labelName":"special","labelType":1,"websiteId":8},{"id":64,"labelName":"OffPrice","labelType":1,"websiteId":8},{"id":65,"labelName":"Presale","labelType":1,"websiteId":8},{"id":66,"labelName":"new","labelType":1,"websiteId":9},{"id":67,"labelName":"hot","labelType":1,"websiteId":9},{"id":68,"labelName":"clearstocks","labelType":2,"websiteId":9},{"id":69,"labelName":"featured","labelType":1,"websiteId":9},{"id":70,"labelName":"freeShipping","labelType":2,"websiteId":9},{"id":71,"labelName":"special","labelType":1,"websiteId":9},{"id":72,"labelName":"OffPrice","labelType":1,"websiteId":9},{"id":73,"labelName":"Presale","labelType":1,"websiteId":9},{"id":74,"labelName":"new","labelType":1,"websiteId":10},{"id":75,"labelName":"hot","labelType":1,"websiteId":10},{"id":76,"labelName":"clearstocks","labelType":2,"websiteId":10},{"id":77,"labelName":"featured","labelType":1,"websiteId":10},{"id":78,"labelName":"freeShipping","labelType":2,"websiteId":10},{"id":79,"labelName":"special","labelType":1,"websiteId":10},{"id":80,"labelName":"OffPrice","labelType":1,"websiteId":10},{"id":81,"labelName":"Presale","labelType":1,"websiteId":10},{"id":82,"labelName":"new","labelType":1,"websiteId":11},{"id":83,"labelName":"hot","labelType":1,"websiteId":11},{"id":84,"labelName":"clearstocks","labelType":2,"websiteId":11},{"id":85,"labelName":"featured","labelType":1,"websiteId":11},{"id":86,"labelName":"freeShipping","labelType":2,"websiteId":11},{"id":87,"labelName":"special","labelType":1,"websiteId":11},{"id":88,"labelName":"OffPrice","labelType":1,"websiteId":11},{"id":89,"labelName":"Presale","labelType":1,"websiteId":11},{"id":90,"labelName":"new","labelType":1,"websiteId":12},{"id":91,"labelName":"hot","labelType":1,"websiteId":12},{"id":92,"labelName":"clearstocks","labelType":2,"websiteId":12},{"id":93,"labelName":"featured","labelType":1,"websiteId":12},{"id":94,"labelName":"freeShipping","labelType":2,"websiteId":12},{"id":95,"labelName":"special","labelType":1,"websiteId":12},{"id":96,"labelName":"OffPrice","labelType":1,"websiteId":12},{"id":97,"labelName":"Presale","labelType":1,"websiteId":12},{"id":98,"labelName":"new","labelType":1,"websiteId":13},{"id":99,"labelName":"hot","labelType":1,"websiteId":13},{"id":100,"labelName":"clearstocks","labelType":2,"websiteId":13},{"id":101,"labelName":"featured","labelType":1,"websiteId":13},{"id":102,"labelName":"freeShipping","labelType":2,"websiteId":13},{"id":103,"labelName":"special","labelType":1,"websiteId":13},{"id":104,"labelName":"OffPrice","labelType":1,"websiteId":13},{"id":105,"labelName":"Presale","labelType":1,"websiteId":13},{"id":106,"labelName":"new","labelType":1,"websiteId":14},{"id":107,"labelName":"hot","labelType":1,"websiteId":14},{"id":108,"labelName":"clearstocks","labelType":2,"websiteId":14},{"id":109,"labelName":"featured","labelType":1,"websiteId":14},{"id":110,"labelName":"freeShipping","labelType":2,"websiteId":14},{"id":111,"labelName":"special","labelType":1,"websiteId":14},{"id":112,"labelName":"OffPrice","labelType":1,"websiteId":14},{"id":113,"labelName":"Presale","labelType":1,"websiteId":14},{"id":114,"labelName":"new","labelType":1,"websiteId":15},{"id":115,"labelName":"hot","labelType":1,"websiteId":15},{"id":116,"labelName":"clearstocks","labelType":2,"websiteId":15},{"id":117,"labelName":"featured","labelType":1,"websiteId":15},{"id":118,"labelName":"freeShipping","labelType":2,"websiteId":15},{"id":119,"labelName":"special","labelType":1,"websiteId":15},{"id":120,"labelName":"OffPrice","labelType":1,"websiteId":15},{"id":121,"labelName":"Presale","labelType":1,"websiteId":15},{"id":122,"labelName":"new","labelType":1,"websiteId":16},{"id":123,"labelName":"hot","labelType":1,"websiteId":16},{"id":124,"labelName":"clearstocks","labelType":2,"websiteId":16},{"id":125,"labelName":"featured","labelType":1,"websiteId":16},{"id":126,"labelName":"freeShipping","labelType":2,"websiteId":16},{"id":127,"labelName":"special","labelType":1,"websiteId":16},{"id":128,"labelName":"OffPrice","labelType":1,"websiteId":16},{"id":129,"labelName":"Presale","labelType":1,"websiteId":16},{"id":130,"labelName":"new","labelType":1,"websiteId":17},{"id":131,"labelName":"hot","labelType":1,"websiteId":17},{"id":132,"labelName":"clearstocks","labelType":2,"websiteId":17},{"id":133,"labelName":"featured","labelType":1,"websiteId":17},{"id":134,"labelName":"freeShipping","labelType":2,"websiteId":17},{"id":135,"labelName":"special","labelType":1,"websiteId":17},{"id":136,"labelName":"OffPrice","labelType":1,"websiteId":17},{"id":137,"labelName":"Presale","labelType":1,"websiteId":17},{"id":138,"labelName":"new","labelType":1,"websiteId":18},{"id":139,"labelName":"hot","labelType":1,"websiteId":18},{"id":140,"labelName":"clearstocks","labelType":2,"websiteId":18},{"id":141,"labelName":"featured","labelType":1,"websiteId":18},{"id":142,"labelName":"freeShipping","labelType":2,"websiteId":18},{"id":143,"labelName":"special","labelType":1,"websiteId":18},{"id":144,"labelName":"OffPrice","labelType":1,"websiteId":18},{"id":145,"labelName":"Presale","labelType":1,"websiteId":18},{"id":146,"labelName":"new","labelType":1,"websiteId":19},{"id":147,"labelName":"hot","labelType":1,"websiteId":19},{"id":148,"labelName":"clearstocks","labelType":2,"websiteId":19},{"id":149,"labelName":"featured","labelType":1,"websiteId":19},{"id":150,"labelName":"freeShipping","labelType":2,"websiteId":19},{"id":151,"labelName":"special","labelType":1,"websiteId":19},{"id":152,"labelName":"OffPrice","labelType":1,"websiteId":19},{"id":153,"labelName":"Presale","labelType":1,"websiteId":19},{"id":154,"labelName":"new","labelType":1,"websiteId":20},{"id":155,"labelName":"hot","labelType":1,"websiteId":20},{"id":156,"labelName":"clearstocks","labelType":2,"websiteId":20},{"id":157,"labelName":"featured","labelType":1,"websiteId":20},{"id":158,"labelName":"freeShipping","labelType":2,"websiteId":20},{"id":159,"labelName":"special","labelType":1,"websiteId":20},{"id":160,"labelName":"OffPrice","labelType":1,"websiteId":20},{"id":161,"labelName":"Presale","labelType":1,"websiteId":20}]
 * @auther ttm
 * @date 2017/10/17
 */
@Entity
@Table(name = "tomtop_product_lable")
public class TomtopProductLabel {

    @Id
    private int id;

    @Column(name = "labelname")
    private String labelName;

    @Column(name = "labeltype")
    private int labelType;

    @Column(name = "websiteid")
    private int websiteId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public int getLabelType() {
        return labelType;
    }

    public void setLabelType(int labelType) {
        this.labelType = labelType;
    }

    public int getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(int websiteId) {
        this.websiteId = websiteId;
    }
}
