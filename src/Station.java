import java.util.*;

/**
 * Created by Administrator on 2017/5/18.
 * Dijkstra
 */
//public class Station{
//    private static List<String> line1=new ArrayList<String>();//#1号线
//    private static List<String> line2=new ArrayList<String>();//#2号线
//    private static List<String> line4=new ArrayList<String>();//#4号线
//
//    private static Set<List<String>> lists=new HashSet<List<String>>();//所有线的集合
//    private static int totalStation=0;//总的站点数量
//    private List<String> outlist=new ArrayList<String>();//记录分析过的点
//
//    public Station(){
//        //1号线
//        String line1Str = "木渎站、金枫路站、汾湖路站、玉山路站、苏州乐园站、塔园路站、滨河路站、西环路站、桐泾北路站、广济南路站、养育巷站、乐桥站、临顿路站、相门站、东环路站、中央公园站、星海广场站、东方之门站、文化博览中心站、时代广场站、星湖街站、南施街站、星塘街站、钟南街站";
//        String[] line1s = line1Str.split("、");
//        for(String s : line1s){
//            line1.add(new Station(s));
//        }
//        for(int i =0;i<line1.size();i++){
//            if(i<line1.size()-1){
//                line1.get(i).next = line1.get(i+1);
//                line1.get(i+1).prev = line1.get(i);
//            }
//        }
//
//        //2号线
//        String line2Str = "高铁苏州北站、大湾站、富元路站、蠡口站、徐图港站、阳澄湖中路站、陆慕站、平泷路东站、平河路站、苏州火车站、山塘街站、石路站、广济南路站、三香广场站、劳动路站、胥江路站、桐泾公园站、友联站、盘蠡路站、新家桥站、石湖东路站、宝带桥南站";
//        String[] line2s = line2Str.split("、");
//        for(String s : line2s){
//            line2.add(new Station(s));
//        }
//        for(int i =0;i<line2.size();i++){
//            if(i<line2.size()-1){
//                line2.get(i).next = line2.get(i+1);
//                line2.get(i+1).prev = line2.get(i);
//            }
//        }
//

//        //4号线
//        String line4Str =
//                  "龙道浜站、张庄站、姚祥站、活力岛站、孙武纪念园站、平泷路西站、苏锦站、苏州火车站、北寺塔站、察院场站、乐桥站、三元坊站、南门站、人民桥南站、团结桥站、宝带路站、石湖东路站、红庄站、清树湾站、花港站、江陵西路站、江兴西路站、流虹路站、笠泽路站、顾家荡站、苏州湾东站、松陵大道站、吴江人民广场站、吴江汽车站、庞金路站、同里站";
//        String[] line4s = line4Str.split("、");
//        for(String s : line4s){
//            line4.add(new Station(s));
//        }
//        for(int i =0;i<line4.size();i++){
//            if(i<line4.size()-1){
//                line4.get(i).next = line4.get(i+1);
//                line4.get(i+1).prev = line4.get(i);
//            }
//        }
//
//        lists.add(line1);
//        lists.add(line2);
//        lists.add(line4);
//        totalStaion  = line1.size() + line2.size() + line4.size();
//    }
//}
