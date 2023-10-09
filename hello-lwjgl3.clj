(import '[org.lwjgl.glfw GLFW]
        '[org.lwjgl.opengl GL]
        '[org.lwjgl Version])

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
  (GLFW/glfwSwapBuffers window)
  (GLFW/glfwPollEvents))

(GLFW/glfwDestroyWindow window)
(GLFW/glfwTerminate)
