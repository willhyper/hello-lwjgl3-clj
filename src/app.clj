(ns app
  (:import (org.lwjgl.glfw GLFW)
           (org.lwjgl.opengl GL GL21)
           (org.lwjgl Version)))

(def width 320)
(def height 240)
(def title (str "Hello LWJGL " (Version/getVersion)))

(GLFW/glfwInit)
(GLFW/glfwDefaultWindowHints)
(def window (GLFW/glfwCreateWindow width height title 0 0))
(GLFW/glfwMakeContextCurrent window)
(GLFW/glfwSwapInterval 1)
(GLFW/glfwShowWindow window)

(GL/createCapabilities)

(while (not (GLFW/glfwWindowShouldClose window))
  (GL21/glClear GL21/GL_COLOR_BUFFER_BIT)

  (GL21/glBegin GL21/GL_TRIANGLES)
  (GL21/glVertex2f -0.5 -0.5)
  (GL21/glVertex2f -0.0 0.5)
  (GL21/glVertex2f 0.5 -0.5)
  (GL21/glEnd)

  (GLFW/glfwSwapBuffers window)
  (GLFW/glfwPollEvents))

(GLFW/glfwDestroyWindow window)
(GLFW/glfwTerminate)
