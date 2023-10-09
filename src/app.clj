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


;; import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;

;;         glfwSetKeyCallback(window, (windowHnd, key, scancode, action, mods) -> {
;;                     if (action != GLFW_RELEASE) {
;;                         return;
;;                     }
        
;;                     switch (key) {
;;                         case GLFW_KEY_ESCAPE:
;;                             glfwSetWindowShouldClose(windowHnd, true);
;;                             break;
;;                         case GLFW_KEY_A:
;;                             glfwRequestWindowAttention(windowHnd);
;;                             break;
;;                         case GLFW_KEY_F:
;;                             if (glfwGetWindowMonitor(windowHnd) == NULL) {
;;                                 try (MemoryStack s = stackPush()) {
;;                                     IntBuffer a = s.ints(0);
;;                                     IntBuffer b = s.ints(0);
        
;;                                     glfwGetWindowPos(windowHnd, a, b);
;;                                     xpos = a.get(0);
;;                                     ypos = b.get(0);
        
;;                                     glfwGetWindowSize(windowHnd, a, b);
;;                                     width = a.get(0);
;;                                     height = b.get(0);
;;                                 }
;;                                 glfwSetWindowMonitor(windowHnd, monitor, 0, 0, vidmode.width(), vidmode.height(), vidmode.refreshRate());
;;                                 glfwSwapInterval(1);
;;                             }
;;                             break;
;;                         case GLFW_KEY_G:
;;                             glfwSetInputMode(windowHnd, GLFW_CURSOR, glfwGetInputMode(windowHnd, GLFW_CURSOR) == GLFW_CURSOR_NORMAL
;;                                 ? GLFW_CURSOR_DISABLED
;;                                 : GLFW_CURSOR_NORMAL
;;                             );
;;                             break;
;;                         case GLFW_KEY_O:
;;                             glfwSetWindowOpacity(window, glfwGetWindowOpacity(window) == 1.0f ? 0.5f : 1.0f);
;;                             break;
;;                         case GLFW_KEY_R:
;;                             glfwSetWindowAttrib(windowHnd, GLFW_RESIZABLE, 1 - glfwGetWindowAttrib(windowHnd, GLFW_RESIZABLE));
;;                             break;
;;                         case GLFW_KEY_U:
;;                             glfwSetWindowAttrib(windowHnd, GLFW_DECORATED, 1 - glfwGetWindowAttrib(windowHnd, GLFW_DECORATED));
;;                             break;
;;                         case GLFW_KEY_W:
;;                             if (glfwGetWindowMonitor(windowHnd) != NULL) {
;;                                 glfwSetWindowMonitor(windowHnd, NULL, xpos, ypos, width, height, 0);
;;                             }
;;                             break;
;;                     }
;;                 });