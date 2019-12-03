/**
 * @license Copyright (c) 2003-2017, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
    // Define changes to default configuration here. For example:
    // config.language = 'fr';
    // config.uiColor = '#AADC6E';
    config.toolbarGroups = [ {
        name : 'others'
    }, {
        name : 'basicstyles',
        groups : [ 'basicstyles', 'cleanup' ]
    }, {
        name : 'styles'
    }, {
        name : 'insert'
    }, {
        name : 'links'
    }, {
        name : 'colors'
    }, {
        name : 'paragraph',
        groups : [ 'list', 'align' ]
    }, {
        name : 'document',
        groups : [ 'mode', 'document', 'doctools' ]
    }, {
        name : 'tools'
    } ];

    config.removePlugins = 'horizontalrule,specialchar,pagebreak,iframe,smiley,flash,preview,blockquote,save,newpage,print,templates,showblocks';
};
