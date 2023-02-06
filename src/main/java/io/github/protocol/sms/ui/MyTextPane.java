/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.github.protocol.sms.ui;

import javax.swing.JTextPane;
import javax.swing.text.BoxView;
import javax.swing.text.ComponentView;
import javax.swing.text.Element;
import javax.swing.text.IconView;
import javax.swing.text.LabelView;
import javax.swing.text.ParagraphView;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;
import java.io.Serializable;

public class MyTextPane extends JTextPane {
   public MyTextPane() {
      this.setEditorKit(new WrapEditorKit());
   }

   protected static final class WrapLabelView extends LabelView {
      public WrapLabelView(Element elem) {
         super(elem);
      }

      public float getMinimumSpan(int axis) {
         switch (axis) {
            case 0:
               return 0.0F;
            case 1:
               return super.getMinimumSpan(axis);
            default:
               throw new IllegalArgumentException("Invalid axis: " + axis);
         }
      }
   }

   protected static class WrapColumnFactory implements ViewFactory, Serializable {
      public View create(Element elem) {
         String kind = elem.getName();
         if (kind != null) {
            if (kind.equals("content")) {
               return new WrapLabelView(elem);
            }

            if (kind.equals("paragraph")) {
               return new ParagraphView(elem);
            }

            if (kind.equals("section")) {
               return new BoxView(elem, 1);
            }

            if (kind.equals("component")) {
               return new ComponentView(elem);
            }

            if (kind.equals("icon")) {
               return new IconView(elem);
            }
         }

         return new LabelView(elem);
      }
   }

   protected static class WrapEditorKit extends StyledEditorKit {
      ViewFactory defaultFactory = new WrapColumnFactory();

      public ViewFactory getViewFactory() {
         return this.defaultFactory;
      }
   }
}
