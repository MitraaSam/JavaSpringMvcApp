package com.mystore.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
public class Product  implements Serializable {

    private static final long serialVersionUID = 6657291566891115824L;
    @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int productId;
        @NotEmpty(message = "Name cannot be empty")
        private String productName;
        private String productCategory;
        private String productDescription;
        @Min(value = 0, message = "The Price must not be less than zero")
        private double productPrice;
        private String productCondition;
        private String productStatus;
       @Min(value = 0, message = "The unit stock must not be less than zero")
        private int unitStock;
        private String productManufacturer;


        @Transient
        private MultipartFile productImage;

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductCategory() {
            return productCategory;
        }

        public void setProductCategory(String productCategory) {
            this.productCategory = productCategory;
        }

        public String getProductDescription() {
            return productDescription;
        }

        public void setProductDescription(String productDescription) {
            this.productDescription = productDescription;
        }

        public double getProductPrice() {
            return productPrice;
        }

        public void setProductPrice(double productPrice) {
            this.productPrice = productPrice;
        }

        public String getProductCondition() {
            return productCondition;
        }

        public void setProductCondition(String productCondition) {
            this.productCondition = productCondition;
        }

        public String getProductStatus() {
            return productStatus;
        }

        public void setProductStatus(String productStatus) {
            this.productStatus = productStatus;
        }

        public int getUnitStock() {
            return unitStock;
        }

        public void setUnitStock(int unitStock) {
            this.unitStock = unitStock;
        }

        public String getProductManufacturer() {
            return productManufacturer;
        }

        public void setProductManufacturer(String productManufacturer) {
            this.productManufacturer = productManufacturer;
        }

        public MultipartFile getProductImage() {
            return productImage;
        }

        public void setProductImage(MultipartFile productImage) {
            this.productImage = productImage;
        }

}
