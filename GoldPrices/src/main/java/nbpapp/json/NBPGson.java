
package nbpapp.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NBPGson {

    @SerializedName("data")
    @Expose
    private String data;
    @SerializedName("cena")
    @Expose
    private Double cena;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

}
