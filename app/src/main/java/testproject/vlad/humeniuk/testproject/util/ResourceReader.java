package testproject.vlad.humeniuk.testproject.util;

import android.content.res.Resources;
import android.support.annotation.RawRes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import testproject.vlad.humeniuk.testproject.R;

public class ResourceReader {

    private Resources resources;

    public ResourceReader(Resources resources) {
        this.resources = resources;
    }

    public String readRawResource(@RawRes int id) {
        InputStream inputStream = resources.openRawResource(R.raw.cachedconfig);

        InputStreamReader inputreader = new InputStreamReader(inputStream);
        BufferedReader buffreader = new BufferedReader(inputreader);
        String line;
        StringBuilder text = new StringBuilder();

        try {
            while (( line = buffreader.readLine()) != null) {
                text.append(line);
            }
        } catch (IOException e) {
            return null;
        } finally {
            try {
                inputreader.close();
                inputStream.close();
            } catch (IOException ignored) {
            }
        }
        return text.toString();
    }
}
