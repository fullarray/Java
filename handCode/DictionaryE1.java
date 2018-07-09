
class dictionaryinjava{

public void main (String [] args){
    Map<String, Label> map = new HashMap<String, Label>();
    for ( String key : map.keySet() ) {
       //for single keys only
    }
    for ( Label value : map.values() ) {
       //for single values
    }
    for ( Map.Entry<String, Label> entry : map.entrySet() ) {
        //for keys and values
        String key = entry.getKey();
        Label value = entry.getValue();
    }
  }

}
