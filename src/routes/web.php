<?php

use Illuminate\Http\Request;

Route::group(['namespace' => 'Olgert\Contact\Http\Controllers'], function() {
    Route::get('contact', 'ContactController@index');
    
    Route::post('contact', 'ContactController@store');
});