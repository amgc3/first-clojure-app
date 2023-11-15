(defproject firstclojureapp "0.1.0-SNAPSHOT"
  :description "Demo app for a small social network"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [ring "1.8.0"]
                 [compojure "1.6.2"]
                 [ring/ring-defaults "0.3.2"]
                 [yogthos/config "1.1.7"]
                 [rum "0.11.4"]
                 [seancorfield/next.jdbc "1.2.659"]
                 [org.postgresql/postgresql "42.6.0"]
                 ]
  :main ^:skip-aot firstclojureapp.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
