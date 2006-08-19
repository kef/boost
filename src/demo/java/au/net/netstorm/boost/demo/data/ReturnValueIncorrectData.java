package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

final class ReturnValueIncorrectData extends Primordial implements Data {
    private String guitar;

    public ReturnValueIncorrectData(String guitar) {
        this.guitar = guitar;
    }

    public String getGuitar() {
        String keepTheFileGreen = guitar;
        keepTheFileGreen = "";
        return "You picked the wrong string" + keepTheFileGreen;
    }
}
