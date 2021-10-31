(ns la.app
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]
            [la.editor :as editor :refer [update-editor! !tri eval-all]]
            [la.math :refer [pi]]))

(defonce tri
  (r/atom {:vertices ["A" "B" "C"]
           :lines [nil nil 1]
           :angles [nil (/ pi 2) (/ pi 6)]}))

(defn app []
  [:div#app
   [:h1 "Linear Algebra with Clojurescript"]
   [editor/editor (str @tri) !tri {:eval? true}]])

(defn render []
  (rdom/render [app]
            (.getElementById js/document "root")))

(defn ^:dev/after-load start []
  (render)
  (js/console.log "start"))

(defn ^:export init []
  (js/console.log "init")
  (start))

(defn ^:dev/before-load stop []
  (js/console.log "stop"))
