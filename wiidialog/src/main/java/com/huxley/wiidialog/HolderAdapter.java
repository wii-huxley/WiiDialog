package com.huxley.wiidialog;

import android.widget.BaseAdapter;

public interface HolderAdapter extends Holder {

  void setAdapter(BaseAdapter adapter);

  void setOnItemClickListener(OnHolderListener listener);

  void setOnItemLongClickListener(OnHolderLongListener listener);
}
