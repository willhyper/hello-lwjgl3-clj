(ns app
  (:import (org.lwjgl.glfw GLFW GLFWKeyCallbackI)
           (org.lwjgl.opengl GL GL21)
           (org.lwjgl Version)))

(def width 320)
(def height 240)
(def title (str "Hello LWJGL " (Version/getVersion)))

(GLFW/glfwInit)
(GLFW/glfwDefaultWindowHints)
(def window (GLFW/glfwCreateWindow width height title 0 0))

(defn opaque? [window]
  (= 1.0 (GLFW/glfwGetWindowOpacity window)))

(defn toggle-opacity [window]
  (let [ opacity (if (opaque? window) 0.5 1.0)]
    (GLFW/glfwSetWindowOpacity window opacity)))

(GLFW/glfwSetKeyCallback window (reify GLFWKeyCallbackI
                                  (invoke [this window key scancode action mods]
                                    (when (= action GLFW/GLFW_RELEASE)
                                        ; We will detect this in the rendering loop
                                      (cond
                                        (= key GLFW/GLFW_KEY_ESCAPE) (GLFW/glfwSetWindowShouldClose window true)
                                        (= key GLFW/GLFW_KEY_O) (toggle-opacity window)
                                        )))))

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
