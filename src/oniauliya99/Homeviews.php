<?php

namespace App\Http\Controllers;
use Illuminate\Http\Response;
use Illuminate\Http\Request;
use App\Definisi;

class Homeviews extends Controller
{
    public function homeviews() {
        return view('homeviews', ['welcome' => 'Welcome :']);
      }
      public function manage() {
        $mikrotik = Definisi::all();
        return view('manages.manage', ['definisis' => $mikrotik]);
      }
      public function create() {
        $mikrotik = Definisi::all();
        return view('manages.create', ['definisis' => $mikrotik]);
      }
      /*
      * Strore a newty created resource in storage.
      *
      
      * @param \Illuminate\Http\Request $request
      * @return \Illuminate\Http\Response
      */
      public function store(Request $request) {
        $request->validate([
          'id'=>'required',
          'judul'=>'required',
          'konten'=>'required'
        ]);
 
        Definisi::create($request->all());
        return redirect('/manage')->with('info', 'Data Added!');
      }
      /*
      * Strore a newty created resource in storage.
      *
      
      * @param \Illuminate\Http\Definisi $definisi
      * @return \Illuminate\Http\Response
      */
      public function destroy(Definisi $id) {
        Definisi::destroy($id->id);
        return redirect('/manage')->with('info', 'Data Deleted!');

      }
      public function edit($id){
        $data = Definisi::find($id);
        return view('layouts.edit',['definisi'=>$data]);
        }
        
      public function update($id, Request $request)
        {
        $data = Definisi::find($id);
        $data->id = $request->id;
        $data->konten = $request->konten;
        $data->judul = $request->judul;
        $data->link = $request->link;
        $data->save();
        return redirect('/manage')->with('info', 'Data Edited!');
 }


}
