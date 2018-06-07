package testproject.vlad.humeniuk.testproject.domain.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class TabConfig implements Parcelable {

    private String title;

    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.body);
    }

    public TabConfig() {
    }

    protected TabConfig(Parcel in) {
        this.title = in.readString();
        this.body = in.readString();
    }

    public static final Parcelable.Creator<TabConfig> CREATOR = new Parcelable.Creator<TabConfig>() {
        @Override
        public TabConfig createFromParcel(Parcel source) {
            return new TabConfig(source);
        }

        @Override
        public TabConfig[] newArray(int size) {
            return new TabConfig[size];
        }
    };

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TabConfig
                && title.equals(((TabConfig) obj).getTitle())
                && body.equals(((TabConfig) obj).getBody());
    }
}
