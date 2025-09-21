package com.example.safestepsphv2;

import com.google.gson.annotations.SerializedName;

public class IllnessBean {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("medicine")
    private String medicine;

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getMedicine() { return medicine; }
}
