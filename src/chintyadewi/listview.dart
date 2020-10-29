import 'package:flutter/material.dart';

class ListViewPage extends StatefulWidget {
  @override
  _ListViewPageState createState() => _ListViewPageState();
}

class _ListViewPageState extends State<ListViewPage> {
  List<Widget> widgets = [];
  int counter = 1;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("List View"),
      ),
      body: ListView(
        children: [
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            children: [
              RaisedButton(
                  onPressed: () {
                    setState(() {
                      widgets.add(Text(
                        "Data " + counter.toString(),
                        style: TextStyle(fontSize: 25),
                      ));
                      counter++;
                    });
                  },
                  child: Text("Tambah Data")),
              RaisedButton(
                  onPressed: () {
                    setState(() {
                      widgets.removeLast();
                      counter--;
                    });
                  },
                  child: Text("Hapus Data"))
            ],
          ),
          Column(
              crossAxisAlignment: CrossAxisAlignment.start, children: widgets)
        ],
      ),
    );
  }
}
