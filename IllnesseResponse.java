package com.example.safestepsphv2;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class IllnessResponse {
    @SerializedName("illnesses")
    private List<IllnessBean> illnesses;

    public List<IllnessBean> getIllnesses() {
        return illnesses;
    }
}
