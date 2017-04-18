package com.huxley.wiidialog;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * dialogHelper
 * Created by huxley on 2017/4/17.
 */
public class DialogHelper {

    public static WiiDialog getSimpleCenter(Context context, String title, String content, String sure, View.OnClickListener listener) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_center_simple, null);
        TextView tvContent = (TextView) view.findViewById(R.id.tv_content);
        tvContent.setText(content);
        return getCenter(context, title, view, "取消", sure, listener);
    }

    public static WiiDialog getCenter(Context context, String title, View contentView, String cancel, String sure, final View.OnClickListener listener) {
        View headerView = LayoutInflater.from(context).inflate(R.layout.dialog_header, null);
        TextView tvTitle = (TextView) headerView.findViewById(R.id.tv_title);
        tvTitle.setText(title);
        View footerView = LayoutInflater.from(context).inflate(R.layout.dialog_footer, null);
        TextView tvCancel = (TextView) headerView.findViewById(R.id.tv_cancel);
        TextView tvSure = (TextView) headerView.findViewById(R.id.tv_sure);
        tvSure.setText(sure);
        tvCancel.setText(cancel);
        final WiiDialog wiiDialog = WiiDialog.newDialog(context)
                .setExpanded(false)
                .setCancelable(true)
                .setGravity(Gravity.CENTER)
                .setContentHolder(new ViewHolder(contentView))
                .setHeader(headerView)
                .setFooter(footerView)
                .create();
        tvSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wiiDialog.dismiss();
                listener.onClick(view);
            }
        });
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wiiDialog.dismiss();
            }
        });
        return wiiDialog;
    }
}
