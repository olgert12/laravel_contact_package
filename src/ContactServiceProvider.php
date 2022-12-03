<?php

namespace Olgert\Contact;

use Illuminate\Support\ServiceProvider;


class ContactServiceProvider extends ServiceProvider
{
    public function boot()
    {
        $this->loadRoutesFrom(__DIR__ . '/routes/web.php');
        $this->loadViewsFrom(__DIR__ .  '/views', 'contact'); //Specify views path + package name
        $this->loadMigrationsFrom(__DIR__ . '/database/migrations'); //load migrations from packages
    }

    public function root()
    {

    }
}