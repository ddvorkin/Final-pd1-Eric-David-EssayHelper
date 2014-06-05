        
        
        while (definition.contains("class=\"iteration\"")){
                            
            if (definition.contains("class=\"partOfSpeech\"")){
                definition = definition.substring(definition.indexOf("class=\"partOfSpeech\""));
                informationArray.add(definition.substring(definition.indexOf(">") + 1, definition.indexOf("<")));
                definition = definition.substring(definition.indexOf("class=\"definition\""));
                informationArray.add(definition.substring(definition.indexOf(">") + 1,definition.indexOf(":")));
                definition = definition.substring(definition.indexOf("class=\"example\""));
                informationArray.add(definition.substring(definition.indexOf(">") + 1,definition.indexOf("<")));
            }
            else{
                informationArray.add("PHRASE");
                definition = definition.substring(definition.indexOf("class=\"definition\""));
                informationArray.add(definition.substring(definition.indexOf(">") + 1, definition.indexOf("<")));
                definition = definition.substring(definition.indexOf("class=\"sentence\""));
                informationArray.add(definition.substring(definition.indexOf(">") + 1,definition.indexOf("<")));
            }
        }