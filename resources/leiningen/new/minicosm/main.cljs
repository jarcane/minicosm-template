(ns {{name}}.main
  (:require [minicosm.core :refer [start!]]
            [minicosm.ddn :refer [render-to-canvas]]))

(enable-console-print!)

(defn init [] 
  [250 250])

(defn assets [] 
  {})

(defn on-key [[x y] key-evs]
  (cond
    (key-evs "ArrowUp") [x (- y 3)]
    (key-evs "ArrowDown") [x (+ y 3)]
    (key-evs "ArrowLeft") [(- x 3) y]
    (key-evs "ArrowRight") [(+ x 3) y]
    :else [x y]))

(defn on-tick [state time]
  state)

(defn to-play [state assets is-playing] 
  {})

(defn to-draw [[x y] assets]
  [:group {:desc "base"}
    [:rect {:style :fill :pos [0 0] :dim [500 500] :color "black"}]
    [:text {:pos [32 32] :color "white" :font "16px serif"} "Hello Space!"]
    [:text {:pos [x y] :color "white" :font "16px"} "🚀"]])

(start!
  {:init init
   :assets assets
   :on-key on-key
   :on-tick on-tick
   :to-play to-play
   :to-draw to-draw})
