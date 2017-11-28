package com.example.antony.openglesexam;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MainActivity extends AppCompatActivity {

    private GLSurfaceView glSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurfaceView = new MyGLSurfaceView(this);
        setContentView(glSurfaceView);
    }

    class MyGLSurfaceView extends GLSurfaceView {

        private MyGLRenderer myGLRender;

        public MyGLSurfaceView(Context context) {
            super(context);
            // Create an OpenGL ES 2.0 context
            setEGLContextClientVersion(2);

            myGLRender = new MyGLRenderer();

            // Set the Renderer for drawing on the GLSurfaceView
            setRenderer(myGLRender);
            setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
        }
    }

    class MyGLRenderer implements GLSurfaceView.Renderer {

        private Triangle triangle;
        private Square square;

        @Override
        public void onSurfaceCreated(GL10 gl, EGLConfig config) {
            // Set the background frame color
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            triangle = new Triangle();
            square = new Square();
        }

        @Override
        public void onSurfaceChanged(GL10 gl, int width, int height) {
            GLES20.glViewport(0, 0, width, height);
        }

        @Override
        public void onDrawFrame(GL10 gl) {
            // Redraw background color
            GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        }
    }
}
