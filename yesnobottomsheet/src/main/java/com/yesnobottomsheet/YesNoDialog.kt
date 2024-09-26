package com.yesnobottomsheet

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.bottomsheet.BottomSheetDialog


object YesNoDialog {


    class Builder(context: Context) {

        private var positiveListener: YesNoDialogListener? = null
        private var negativeListener: YesNoDialogListener? = null

        private var isCancellable: Boolean = true
        private var titleTxt: String = ""
        private var messageTxt: String = ""
        private var yesTxt: String = ""
        private var noTxt: String = ""
        private val mContext = context
        private var yesBackgroundColor: Int = 0 // Default color
        private var noBorderColor: Int = 0

        fun setMessage(message: String): Builder {
            messageTxt = message
            return this
        }

        fun isCancellable(data: Boolean): Builder {
            isCancellable = data
            return this
        }

        fun setYesText(txt: String): Builder {
            yesTxt = txt
            return this
        }

        fun setNoText(txt: String): Builder {
            noTxt = txt
            return this
        }

        fun setTitleTxt(txt: String): Builder {
            titleTxt = txt
            return this
        }

        fun onPositiveClick(listener: YesNoDialogListener): Builder {
            positiveListener = listener
            return this
        }

        fun onNegativeClick(listener: YesNoDialogListener): Builder {
            negativeListener = listener
            return this
        }

        fun setYesBackgroundColor(colorResId: Int): Builder {
            yesBackgroundColor = ContextCompat.getColor(mContext, colorResId)
            return this
        }

        // Method to accept color from resources (R.color.colorCode)
        fun setNoBorderColor(colorResId: Int): Builder {
            noBorderColor = ContextCompat.getColor(mContext, colorResId)
            return this
        }

        fun build(): BottomSheetDialog {
            val dialog = BottomSheetDialog(mContext)
            dialog.setContentView(R.layout.model_bottom_sheet_yes_no)
            dialog.setCancelable(isCancellable)

            val title = dialog.findViewById<TextView>(R.id.title)
            val message = dialog.findViewById<TextView>(R.id.message)
            val cancel = dialog.findViewById<TextView>(R.id.cancel)
            val yes = dialog.findViewById<TextView>(R.id.yes)

            title?.text = titleTxt
            message?.text = messageTxt
            yes?.text = yesTxt
            cancel?.text = noTxt


            if (noTxt.isEmpty()) {
                cancel?.visibility = View.INVISIBLE
            } else {
                cancel?.visibility = View.VISIBLE
            }

            if (positiveListener != null) {
                yes?.setOnClickListener {
                    dialog.dismiss()
                    positiveListener?.onClick()
                }
            }

            if (negativeListener != null) {
                cancel?.setOnClickListener {
                    dialog.dismiss()
                    negativeListener?.onClick()
                }
            }

            // Set dynamic background color for Yes button
            yes?.background = ContextCompat.getDrawable(mContext, R.drawable.rounded_primary_selected)?.apply {
                (this as GradientDrawable).setColor(yesBackgroundColor)
            }

            // Set dynamic border color for No button
            cancel?.background = ContextCompat.getDrawable(mContext, R.drawable.rounded_black_outline)?.apply {
                (this as GradientDrawable).setStroke(1, noBorderColor)
            }

            dialog.show()
            return dialog
        }

    }


}