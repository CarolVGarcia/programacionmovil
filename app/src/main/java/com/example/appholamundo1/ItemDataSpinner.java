package com.example.appholamundo1;

public class ItemDataSpinner {

    private String textCategoria;
    private String textDescripcion;
    private int imageId;

    public ItemDataSpinner() {
        this.textCategoria = "";
        this.textDescripcion = "";
        this.imageId = 0;
    }

    public ItemDataSpinner(String textCategoria, String textDescripcion, int imageId) {
        this.textCategoria = textCategoria;
        this.textDescripcion = textDescripcion;
        this.imageId = imageId;
    }

    public ItemDataSpinner(ItemDataSpinner item) {
        this.textCategoria = item.textCategoria;
        this.textDescripcion = item.textDescripcion;
        this.imageId = item.imageId;
    }


    public String getTextCategoria() {
        return textCategoria;
    }

    public void setTextCategoria(String textCategoria) {
        this.textCategoria = textCategoria;
    }

    public String getTextDescripcion() {
        return textDescripcion;
    }

    public void setTextDescripcion(String textDescripcion) {
        this.textDescripcion = textDescripcion;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }



}
