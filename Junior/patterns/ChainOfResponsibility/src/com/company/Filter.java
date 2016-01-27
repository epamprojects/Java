package com.company;

/**
 * Created by Mykolai_Lytvyn on 27.01.2016.
 */
public interface Filter {
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChaine filterChaine);
}
