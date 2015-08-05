(defproject clojure-noob "0.1.0-SNAPSHOT"
  :description "Work from Class - Closure for the Brave and True"
  :url "http://www.braveclojure.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot clojure-noob.core
  :target-path "target/%s"
  :plugins [[lein-gorilla "0.3.4"]]
  :profiles {:uberjar {:aot :all}})
