package com.example.databinding_module

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.TextView
import android.widget.Toast
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.MockitoAnnotations.initMocks
import org.powermock.api.mockito.PowerMockito.*
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest(ClipData::class,Toast::class,ViewModel::class)
class ViewModelTest{
    val mockTextView = Mockito.mock(TextView::class.java)
    val mockTextViewClip = Mockito.mock(TextView::class.java)
    val clipboardManager = Mockito.mock(ClipboardManager::class.java)
    val clipData = Mockito.mock(ClipData::class.java)
    val mockContext = Mockito.mock(Context::class.java)

    @Before
    fun setUp() {
//        initMocks(this)
        mockStatic(ClipData::class.java)
        mockStatic(Toast::class.java)
        mockStatic(ViewModel::class.java)
        `when`(mockTextView.text).thenReturn("hhh")
        `when`(mockTextView.context).thenReturn(mockContext)
        `when`(mockContext.getSystemService(Context.CLIPBOARD_SERVICE)).thenReturn(clipboardManager)
        `when`(ClipData.newPlainText("text",mockTextViewClip.text)).thenReturn(clipData)
        doNothing().`when`(clipboardManager).setPrimaryClip(clipData)
    }

    @Test
    fun `Verify calls when copyToast is false and onCopyClick is true`(){
        `when`(ViewModel.copyOnClick(mockTextView)).thenCallRealMethod()
        verify(mockTextView, times(1)).context
        verify(mockTextView, times(1)).text
    }

    @Test
    fun `Verify calls when copyToast is true and onCopyClick is false`(){
        `when`(ViewModel.showToast(mockTextView)).thenAnswer{ViewModel.showToast(mockTextView)}
        verify(mockTextView, times(1)).context
        verify(mockTextView, times(0)).text
    }

    @Test
    fun `Verify calls when copyToast is true and onCopyClick is true`(){
        `when`(ViewModel.copyOnClick(mockTextView)).thenCallRealMethod()
        `when`(ViewModel.showToast(mockTextView)).thenAnswer{ViewModel.showToast(mockTextView)}
        verify(mockTextView, times(2)).context
        verify(mockTextView, times(1)).text
    }

    @Test
    fun `Verify calls when copyToast is false and onCopyClick is false`(){
        verify(mockTextView, times(0)).context
        verify(mockTextView, times(0)).text
    }
}