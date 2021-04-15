package com.example.componenttextfield

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.widget.SwitchCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class EditTextCustom(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {
    private var edtField: EditText = EditText(context)
    private var imvIcon: ImageView = ImageView(context)
    private var swtAvailable: SwitchCompat = SwitchCompat(context)

    init {
        inflate(context, R.layout.layout_edt_custom, this)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.EditTextCustomized)
        edtField = findViewById(R.id.edt_field)
        imvIcon = findViewById(R.id.imv_icon)
        swtAvailable = findViewById(R.id.swt_available)

        fieldVisibility()

        shouldShowIcon(attributes)

        localThemeSetup(attributes)

        attributes.recycle()
    }

    private fun localThemeSetup(attributes: TypedArray) {
        val localTheme = attributes.getInt(R.styleable.EditTextCustomized_localTheme, 0)
        setLocalTheme(localTheme)
    }

    private fun fieldVisibility() {
        swtAvailable.isChecked = true
        swtAvailable.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                edtField.visibility = VISIBLE
            } else {
                edtField.visibility = INVISIBLE
            }
        }
    }

    private fun shouldShowIcon(attributes: TypedArray) {
        val shouldShowIcon = attributes.getBoolean(R.styleable.EditTextCustomized_shouldShowIcon, true)
        if (shouldShowIcon) {
            imvIcon.visibility = VISIBLE
        } else {
            imvIcon.visibility = INVISIBLE
        }
    }

    /*
    TEMA 1: VERDE
    TEMA 2: CINZA
    */
    fun setLocalTheme(theme: Int) {
        when(theme) {
            1 -> {
                edtField.setBackgroundColor(ContextCompat.getColor(context, R.color.verde))
            }
            2 -> {
                edtField.setBackgroundColor(ContextCompat.getColor(context, R.color.cinza))
            }
            else -> {
                edtField.setBackgroundColor(ContextCompat.getColor(context, R.color.white))
            }
        }
    }
}