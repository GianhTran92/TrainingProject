package vn.asiantech.learnenglish.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by conall on 03/09/2015.
 */
@Setter
@Getter
public class TopModel {
    public TopModel(String title, int avatar) {
        this.idAvatar = avatar;
        this.title = title;
    }

    private int idAvatar;
    private String title;
}