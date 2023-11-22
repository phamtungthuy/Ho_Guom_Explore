package org.meicode.ho_guom_explore.UserInterface.MainPage;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogFragment extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Hồ Gươm Explore")
                .setMessage("Nếu có bất kỳ phản hồi nào hãy thông báo lại với chúng tôi ở phần đánh giá" + "\n" +
                        "Chúng tôi luôn sẵn sàng lắng nghe ý kiến của các bạn!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        return builder.create();
    }
}
