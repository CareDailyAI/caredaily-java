package com.peoplepowerco.virtuoso.models.storybook;

import android.os.Build.VERSION_CODES;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Objects;

/**
 * Created by edwardliu on 2018/9/14.
 */

public class PPLocationSpaceModel {

    private int id = PPLocationSpaceTypeNone;
    private int type;
    private String name;
    private boolean isSelected = false;

    public static final int PPLocationSpaceTypeNone = -1;
    public static final int PPLocationSpaceTypeUndefined = 0;
    public static final int PPLocationSpaceTypeKitchen = 1;
    public static final int PPLocationSpaceTypeBedroom = 2;
    public static final int PPLocationSpaceTypeBathroom = 3;
    public static final int PPLocationSpaceTypeHallway = 4;
    public static final int PPLocationSpaceTypeLivingRoom = 5;
    public static final int PPLocationSpaceTypeDiningRoom = 6;
    public static final int PPLocationSpaceTypeFamilyRoom = 7;
    public static final int PPLocationSpaceTypeLaundryRoom = 8;
    public static final int PPLocationSpaceTypeOffice = 9;
    public static final int PPLocationSpaceTypeStairs = 10;
    public static final int PPLocationSpaceTypeGarage = 11;
    public static final int PPLocationSpaceTypeBasement = 12;
    public static final int PPLocationSpaceTypeOther = 13;

    public PPLocationSpaceModel() {
    }

    public PPLocationSpaceModel(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public PPLocationSpaceModel(int type) {
        id = -1;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsActived() {
        return isSelected;
    }

    public void setIsActived(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public String getJsonStr() {
        StringBuilder builder = new StringBuilder();
        boolean appendComma = false;
        builder.append("{");
        if (type != PPLocationSpaceTypeNone) {
            builder.append(String.format("\"type\": %d", type));
            appendComma = true;
        }
        if (!TextUtils.isEmpty(name)) {
            if (appendComma) {
                builder.append(",");
            }
            builder.append(String.format("\"name\": \"%s\"", name));
        }
        builder.append("}");
        String result = builder.toString();
        result = String.format("{\"space\": %s}", result);
        return result;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof PPLocationSpaceModel) {
            PPLocationSpaceModel other = (PPLocationSpaceModel) obj;
            if (id == other.id) {
                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(other.name)) {
                    return true;
                } else if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(other.name) && name.equals(other.name)) {
                    return true;
                }
            }
        }
        return false;
    }

    @RequiresApi(api = VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
