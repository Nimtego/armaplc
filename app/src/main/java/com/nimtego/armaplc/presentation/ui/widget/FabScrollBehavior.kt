package com.nimtego.armaplc.presentation.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FabScrollBehavior : CoordinatorLayout.Behavior<FloatingActionButton> {

// MARK: - Construction

    constructor() : super()

    constructor(context: Context, attrs: AttributeSet): super(context, attrs)

// MARK: - Methods

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton,
                                     directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton,
                                target: View, dxConsumed: Int, dyConsumed: Int,
                                dxUnconsumed: Int, dyUnconsumed: Int, type: Int) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type)

        if (dyConsumed > 0) {
            slideDown(child)
        }
        else {
            if (dyConsumed < 0) {
                slideUp(child);
            }
        }
    }

    private fun slideUp(child: FloatingActionButton) {
        child.clearAnimation();
        child.animate().translationY(VIEW_HIDDEN_HEIGHT).duration = ANIMATION_DURATION;
    }

    private fun slideDown(child: FloatingActionButton) {
        child.clearAnimation();
        child.animate().translationY(VIEW_SHOWN_HEIGHT).duration = ANIMATION_DURATION;
    }

// MARK: - Companion

    companion object {
        private const val VIEW_HIDDEN_HEIGHT = 0f
        private const val VIEW_SHOWN_HEIGHT: Float = 300f
        private const val ANIMATION_DURATION = 300L
    }
}
