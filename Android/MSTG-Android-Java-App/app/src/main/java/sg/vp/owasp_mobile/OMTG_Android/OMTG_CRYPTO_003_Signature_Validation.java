package sg.vp.owasp_mobile.OMTG_Android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;

public class OMTG_CRYPTO_003_Signature_Validation extends AppCompatActivity {
    String TAG = "OMTG_CRYPTO_003_Signature_Validation";
    String PACKAGE_FILE_URL = "https://downloads.openwrt.org/releases/packages-21.02/mips_4kec/base/Packages";
    String PACKAGE_FILE_SIG_URL = "https://downloads.openwrt.org/releases/packages-21.02/mips_4kec/base/Packages.asc";

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_omtg__crypto_003__signature__validation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnValidate = (Button) findViewById(R.id.SignatureValidationButton);
        Log.w(TAG, "in onCreate");
        // create click listener for firmware validation
        View.OnClickListener oclbtnValidate = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w(TAG, "in onClick");
                Boolean result = Boolean.FALSE;
                Log.w(TAG, String.format("result=%s", result.toString()));

                try {
                    result = isFirmwareValid("tbd");
                    Log.w(TAG, String.format("result=%s", result.toString()));
                } catch (Exception e) {
                    Log.w(TAG, Log.getStackTraceString(e.getCause().getCause()));
                }
                result(result);
            }
        };

        // assign click listener to the Validate button
        btnValidate.setOnClickListener(oclbtnValidate);
    }

    private void result(Boolean result) {

        if (result) {
            Toast.makeText(this, "Congratulations, the firmware is valid", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Try again!", Toast.LENGTH_LONG).show();
        }
    }
    public native boolean isFirmwareValid(String path);

    static {
        System.loadLibrary("native-lib");
    }
}