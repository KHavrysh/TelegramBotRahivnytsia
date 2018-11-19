package com.company;

import static com.company.Keyboard.inline;

public class BotManager {
//    private static BotManager instance;
//
//    public static synchronized BotManager getInstance() {
//        if (instance == null){
//           BotManager = new BotManager();
//        }
//        return instance;
//    }

public IBuilder create (Keyboard k){
        if (k == Keyboard.inline){
            return new InlineBuilder();
    }else if(k == Keyboard.reply){
            return new ReplyBuilder();
        }
        else{
            return null;
        }
}


}
