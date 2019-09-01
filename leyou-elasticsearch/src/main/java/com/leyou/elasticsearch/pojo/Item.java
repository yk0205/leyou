package com.leyou.elasticsearch.pojo;



import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Description TODO
 * @Author yk
 * @Date 2019/9/1 13:56
 */
@Document(indexName = "item", type = "docs", shards = 1, replicas = 0)
public class Item {

    @Id
    private Long id;   //标题
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;  //
    @Field(type = FieldType.Keyword)
    private String category; // 分类
    @Field(type = FieldType.Keyword)
    private String brand;    //  品牌
    @Field(type = FieldType.Double)
    private Double price;    // 价格
    @Field(type = FieldType.Keyword, index = false)
    private String images;    // 图片地址

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
