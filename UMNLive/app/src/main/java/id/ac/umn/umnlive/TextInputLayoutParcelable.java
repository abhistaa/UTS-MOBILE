package id.ac.umn.umnlive;

import android.os.Parcel;
import android.os.Parcelable;

public class TextInputLayoutParcelable implements Parcelable {
    private String textInputValue;

    public TextInputLayoutParcelable(String textInputValue) {
        this.textInputValue = textInputValue;
    }

    public String getTextInputValue() {
        return textInputValue;
    }

    protected TextInputLayoutParcelable(Parcel in) {
        textInputValue = in.readString();
    }

    public static final Creator<TextInputLayoutParcelable> CREATOR = new Creator<TextInputLayoutParcelable>() {
        @Override
        public TextInputLayoutParcelable createFromParcel(Parcel in) {
            return new TextInputLayoutParcelable(in);
        }

        @Override
        public TextInputLayoutParcelable[] newArray(int size) {
            return new TextInputLayoutParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(textInputValue);
    }
}



