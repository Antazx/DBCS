/*
 *  DTO basado en JavaBeans. Como creo que no es necesario para este creamos y
 * usamos el otro
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;

/**
 *
 * @author Carlos
 */
public class ProductDTO implements Serializable {

    private int id;
    private String prod_desc;
    private float price;
    private String item_id;

    /**
     * Get the value of Item_id
     *
     * @return the value of Item_id
     */
    public String getItem_id() {
        return item_id;
    }

    /**
     * Set the value of Item_id
     *
     * @param Item_id new value of Item_id
     */
    public void setItem_id(String Item_id) {
        this.item_id = Item_id;
    }


    /**
     * Get the value of price
     *
     * @return the value of price
     */
    public float getPrice() {
        return price;
    }

    /**
     * Set the value of price
     *
     * @param price new value of price
     */
    public void setPrice(float price) {
        this.price = price;
    }


    /**
     * Get the value of prod_desc
     *
     * @return the value of prod_desc
     */
    public String getProd_desc() {
        return prod_desc;
    }

    /**
     * Set the value of prod_desc
     *
     * @param prod_desc new value of prod_desc
     */
    public void setProd_desc(String prod_desc) {
        this.prod_desc = prod_desc;
    }


    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
    }

    
    public ProductDTO() {
    }
    
    
}
