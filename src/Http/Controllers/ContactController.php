<?php

namespace Olgert\Contact\Http\Controllers;

use Illuminate\Http\Request;
use Olgert\Contact\Models\Contact;
use App\Http\Controllers\Controller;

class ContactController extends Controller
{
    public function index()
    {
        return view('contact::index'); //Return packagename::with blade file
    }

    public function store(Request $request)
    {
        Contact::create($request->all());
        
        return redirect(url('contact'));
    }
}
