(ns firstclojureapp.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [compojure.core :refer [GET defroutes]]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [config.core :refer [env]]
            [rum.core :refer [defc render-static-markup]]
            )
  (:gen-class))

(defc template [headline component]
      [:div {:id "main-div"
             :class "main-page-div"}
       [:h1 headline]
       (component)])

(defc main-page []
      [:p "Welcome to the main page"])
(defc friends-page []
      [:p "This is the friends page, still work in progress"])

(defroutes app
           (GET "/" [] (render-static-markup (template "Hello There" main-page)))
           (GET "/friends" [] (render-static-markup (template "No friends yet :(" friends-page))
                ))

;(defn app-handler [request]
;  {:status 200
;    :headers {"Content-Type" "text/html"}
;    :body "<html><body><h1>Hello, there!</h1></body></html>"})

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; jetty wev server used by ring, app is a handler to it. We wrap
  (run-jetty (wrap-defaults app site-defaults)  {:port (:port env)}))
