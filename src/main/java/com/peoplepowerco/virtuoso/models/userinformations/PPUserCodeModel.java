package com.peoplepowerco.virtuoso.models.userinformations;


public class PPUserCodeModel {

    private int type = 0;
    private String name = null;
    private boolean delete = false;
    private boolean selectedToDelete = false;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String code) {
        this.name = code;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isSelectedToDelete() {
        return selectedToDelete;
    }

    public void setSelectedToDelete(boolean selectedToDelete) {
        this.selectedToDelete = selectedToDelete;
    }
}
