package com.peoplepowerco.virtuoso.models.storybook;

import java.util.ArrayList;
import java.util.List;

public class DeviceBundle {
    public List<String> accessories = new ArrayList<>();
    public List<Model> models = new ArrayList<>();
    public Model accessModel;
    public String storyId;
    public List<Integer> iconIndexes;
}
