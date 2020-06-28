(ns leiningen.new.minicosm
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "minicosm"))

(defn minicosm
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' minicosm project.")
    (->files data
             ["src/{{sanitized}}/main.cljs" (render "main.cljs" data)]
             ["resources/public/index.html" (render "index.html" data)]
             ["resources/public/css/style.css" (render "style.css" data)]
             ["project.clj" (render "project.clj" data)]
             ["dev/user.clj" (render "user.clj" data)]
             ["README.md" (render "README.md" data)]
             [".gitignore" (render ".gitignore" data)])))
