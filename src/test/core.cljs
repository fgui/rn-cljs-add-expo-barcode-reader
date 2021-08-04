(ns test.core
  (:require [steroid.rn.core :as rn]
            [reagent.core :as reagent]
            ["expo-barcode-scanner" :as ebs])
  )


(def bar-code-scanner (reagent/adapt-react-class ebs/BarCodeScanner))

(defn root-comp []
  [rn/view {:style {:flex 1 :flex-direction :column :justify-content :center}}
   ;;[rn/text "Hello CLojure! from CLJS"]
   [bar-code-scanner
    {
     :style {
             :flex 1,
             :justify-content :flex-end
             :align-items :center}
     :barcode-types [ebs/BarCodeScanner.Constants.BarCodeType.code128]
     :on-bar-code-scanned #(js/alert (.-data %))} 
    ]
   ])

(defn init []
  (rn/register-reload-comp "Test" root-comp))

