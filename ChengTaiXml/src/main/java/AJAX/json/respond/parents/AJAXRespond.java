package AJAX.json.respond.parents;

import AJAX.View;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

/**
 * This is an ajax respond class
 * @param <T> 'T' is the data type sent back to user side.
 */
public class AJAXRespond<T> {

    @JsonView(View.Public.class)
    String msg;

    @JsonView(View.Public.class)
    String code;

    @JsonView(View.Public.class)
    List<T> dataList;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public void addData(T newData) {
        this.dataList.add(newData);
    }

}
